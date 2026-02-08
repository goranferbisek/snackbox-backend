package si.ferbisek.snackbox.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.ferbisek.snackbox.dto.CreateMerchantRequest;
import si.ferbisek.snackbox.dto.MerchantDto;
import si.ferbisek.snackbox.entity.Category;
import si.ferbisek.snackbox.entity.Merchant;
import si.ferbisek.snackbox.entity.User;
import si.ferbisek.snackbox.mappers.MerchantMapper;
import si.ferbisek.snackbox.repository.UserRepository;
import si.ferbisek.snackbox.service.CategoryService;
import si.ferbisek.snackbox.service.MerchantService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;
    private final MerchantMapper merchantMapper;
    private final UserRepository userRepository;
    private final CategoryService categoryService;

    @PostMapping(path = "/merchants")
    public ResponseEntity<MerchantDto> saveMerchant(@Valid @RequestBody CreateMerchantRequest newMerchant) {
        Merchant merchantEntity = merchantMapper.mapFrom(newMerchant);

        // TODO set owner as currently logged in user
        // this is temporary
        User demoUser = userRepository.findByEmail("user@test.com")
                .orElseThrow(() -> new IllegalArgumentException("Demo user not found"));
        merchantEntity.setOwner(demoUser);

        Category category = categoryService.findById(newMerchant.getCategoryId()).orElseThrow(() ->
                new IllegalArgumentException("Category id: " + newMerchant.getCategoryId() + " does not exist")
        );
        merchantEntity.setCategory(category);

        Merchant savedEntity = merchantService.save(merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(savedEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/merchants")
    public Page<MerchantDto> listMerchants(Pageable pageable) {
        Page<Merchant> merchants = merchantService.findAll(pageable);
        return merchants.map(merchantMapper::mapTo);
    }

    @GetMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> findById(@PathVariable Long id) {
        Optional<Merchant> foundMerchant = merchantService.findOne(id);

        return foundMerchant.map(merchantEntity -> {
            MerchantDto merchantDto =  merchantMapper.mapTo(merchantEntity);
            return new ResponseEntity<>(merchantDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> fullUpdateMerchant(@PathVariable Long id, @RequestBody MerchantDto merchant) {
        if (!merchantService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        merchant.setId(id);
        Merchant merchantEntity =  merchantMapper.mapFrom(merchant);
        Merchant savedMerchant =  merchantService.save(merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(savedMerchant), HttpStatus.OK);
    }

    @PatchMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> partialUpdateMerchant(@PathVariable Long id, @RequestBody MerchantDto merchant) {
        if (!merchantService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Merchant merchantEntity =  merchantMapper.mapFrom(merchant);
        Merchant updatedMerchant = merchantService.partialUpdate(id, merchantEntity);
        return new ResponseEntity<>(merchantMapper.mapTo(updatedMerchant), HttpStatus.OK);
    }

    @DeleteMapping(path = "/merchants/{id}")
    public ResponseEntity<MerchantDto> deleteMerchant(@PathVariable Long id) {
        merchantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

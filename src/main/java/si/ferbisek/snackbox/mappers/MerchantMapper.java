package si.ferbisek.snackbox.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import si.ferbisek.snackbox.entity.Merchant;
import si.ferbisek.snackbox.dto.MerchantDto;

@Component
public class MerchantMapper implements Mapper<Merchant, MerchantDto> {

    private final ModelMapper modelMapper;

    public MerchantMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MerchantDto mapTo(Merchant merchant) {
        return modelMapper.map(merchant, MerchantDto.class);
    }

    @Override
    public Merchant mapFrom(MerchantDto merchantDTO) {
        return modelMapper.map(merchantDTO, Merchant.class);
    }
}

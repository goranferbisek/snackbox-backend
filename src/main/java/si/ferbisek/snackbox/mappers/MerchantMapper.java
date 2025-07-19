package si.ferbisek.snackbox.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import si.ferbisek.snackbox.merchant.presentation.MerchantDto;
import si.ferbisek.snackbox.merchant.persistence.MerchantEntity;

@Component
public class MerchantMapper implements Mapper<MerchantEntity, MerchantDto> {

    private ModelMapper modelMapper;

    public MerchantMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MerchantDto mapTo(MerchantEntity merchantEntity) {
        return modelMapper.map(merchantEntity, MerchantDto.class);
    }

    @Override
    public MerchantEntity mapFrom(MerchantDto merchantDTO) {
        return modelMapper.map(merchantDTO, MerchantEntity.class);
    }
}

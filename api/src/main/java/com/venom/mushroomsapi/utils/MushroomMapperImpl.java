package com.venom.mushroomsapi.utils;

import com.venom.mushroomsapi.models.Mushroom;
import com.venom.mushroomsapi.utils.base.MushroomMapper;
import com.venom.mushroomsapi.viewmodels.MushroomDetailsViewModel;
import com.venom.mushroomsapi.viewmodels.MushroomViewModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MushroomMapperImpl implements MushroomMapper {
    @Override
    public MushroomViewModel map(Mushroom model) {
        MushroomViewModel vm = new MushroomViewModel();
        vm.id = model.getId();
        vm.name = model.getName();
        vm.secretIdentity = model.getSecretIdentity();
        vm.imageUrl = model.getImageUrl();
        return vm;
    }

    @Override
    public Mushroom map(MushroomViewModel viewModel) {
        Mushroom model = new Mushroom();
        model.setId(viewModel.id);
        model.setName(viewModel.name);
        model.setSecretIdentity(viewModel.secretIdentity);
        model.setImageUrl(viewModel.imageUrl);
        return model;
    }

    @Override
    public List<MushroomViewModel> mapMany(List<Mushroom> models) {
        return models.stream()
            .map(this::map)
            .collect(Collectors.toList());
    }

    @Override
    public MushroomDetailsViewModel mapDetails(Mushroom model) {
        MushroomDetailsViewModel vm = new MushroomDetailsViewModel();
        vm.id = model.getId();
        vm.name = model.getName();
        vm.secretIdentity = model.getSecretIdentity();
        vm.imageUrl=model.getImageUrl();
        return vm;
    }
}

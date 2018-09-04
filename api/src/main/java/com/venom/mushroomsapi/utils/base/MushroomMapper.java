package com.venom.mushroomsapi.utils.base;

import com.venom.mushroomsapi.models.Mushroom;
import com.venom.mushroomsapi.viewmodels.MushroomDetailsViewModel;
import com.venom.mushroomsapi.viewmodels.MushroomViewModel;

import java.util.List;

public interface MushroomMapper {
    MushroomViewModel map(Mushroom model);

    Mushroom map(MushroomViewModel viewModel);

    List<MushroomViewModel> mapMany(List<Mushroom> models);

    MushroomDetailsViewModel mapDetails(Mushroom model);
}

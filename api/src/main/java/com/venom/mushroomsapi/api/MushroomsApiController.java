package com.venom.mushroomsapi.api;

import com.venom.mushroomsapi.models.Mushroom;
import com.venom.mushroomsapi.services.base.MushroomsService;
import com.venom.mushroomsapi.utils.base.MushroomMapper;
import com.venom.mushroomsapi.viewmodels.MushroomDetailsViewModel;
import com.venom.mushroomsapi.viewmodels.MushroomViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Mushrooms")
public class MushroomsApiController {
    private final MushroomsService mushroomsService;
    private final MushroomMapper mapper;

    @Autowired
    public MushroomsApiController(MushroomsService mushroomsService, MushroomMapper mapper) {
        this.mushroomsService = mushroomsService;
        this.mapper = mapper;
    }

    @RequestMapping(
        method = RequestMethod.GET
    )
    public List<MushroomViewModel> getAllMushrooms() {
        List<Mushroom> models = this.mushroomsService.getAllMushrooms();
        return this.mapper.mapMany(models);
    }

    @RequestMapping(
        value = "/{id}",
        method = RequestMethod.GET
    )
    public MushroomDetailsViewModel getMushroomById(@PathVariable("id") String idString) {
        int id = Integer.parseInt(idString);
        Mushroom model = this.mushroomsService.findMushroomById(id);
        return this.mapper.mapDetails(model);
    }

    @RequestMapping(
        method = RequestMethod.POST
    )
    public ResponseEntity<MushroomViewModel> createMushroom(@RequestBody MushroomViewModel mushroomVm) {
        Mushroom model = this.mapper.map(mushroomVm);
        Mushroom mushroom = this.mushroomsService.create(model);
        MushroomViewModel vmToReturn = this.mapper.map(mushroom);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(vmToReturn);
    }
}

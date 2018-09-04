package com.venom.mushroomsapi;


import com.venom.mushroomsapi.models.Mushroom;
import com.venom.mushroomsapi.repositories.base.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MushroomsapiApplication {

    @Autowired
    public MushroomsapiApplication(GenericRepository<Mushroom> superheroesRepository) {
        List<Mushroom> initialMushrooms = Arrays.asList(
                new Mushroom(1,"Обикновена манатарка", "Манатарка (Boletus) е род базидиеви гъби от семейство Манатаркови (Boletaceae) чиито членове се наричат манатарки. Някои видове от същото семейство, но от друг род също се наричат манатарки. Сред тях са различните видове масловки, брезовки и др. В горите на България са доста разпространени различните видове, и особено високо ценената обикновена манатарка. Гъбите от този род плододават сравнително едри, понякога огромни тела. Спорообразуващият слой на всеки вид е под формата на гъсти тръбички и се намира в долната част на гуглата която често е под формата на кръгла кифла. Пънчетата им обикновено са дебели особено в основата и са украсени с мрежести ивици или цветни точици.", "http://manatarka.org/files/2011/12/Boletusedulis4.jpg"),
                new Mushroom(2,"Алпийска чашка", "Microstoma protractum is a species of cup fungus in the family Sarcoscyphaceae.", "http://manatarka.org/files/2016/03/Microstomaprotractum1.jpg"),
                new Mushroom(3,"Виолетов вълчи зъб", "Вълчият зъб, още Патуйардова гъба(Inocybe erubescens), е силно отровна базидиева гъба от род Inocybe.", "http://manatarka.org/files/2018/05/Inocybegeophylla7.jpg")
        );
        initialMushrooms
            .forEach(superheroesRepository::add);
    }

    public static void main(String[] args) {
        SpringApplication.run(MushroomsapiApplication.class, args);
    }
}

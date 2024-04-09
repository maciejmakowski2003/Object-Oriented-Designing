package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Date;
import pl.edu.agh.dronka.shop.model.Genre;
import pl.edu.agh.dronka.shop.model.items.*;

import java.util.Map;

public class ItemInfoProvider {
    public Item createItemByCategory(String name, Category category, int price, int quantity,
                                  CSVReader reader, String[] dataLine) {
        switch (category) {
            case BOOKS:
                int pageNumber = Integer.parseInt(reader.getValue(dataLine,
                        "Liczba stron"));
                boolean hardCover = Boolean.parseBoolean(reader.getValue(dataLine,
                        "Twarda oprawa"));
                return new Book(name, category, price, quantity, pageNumber, hardCover);
            case ELECTRONICS:
                boolean isMobile = Boolean.parseBoolean(reader.getValue(dataLine,
                        "Mobilny"));
                boolean isGuarantee = Boolean.parseBoolean(reader.getValue(dataLine,
                        "Gwarancja"));
                return new Electronics(name, category, price, quantity, isMobile, isGuarantee);
            case FOOD:
                String strDate = reader.getValue(dataLine,"Data przydatności do spożycia");
                Date date = new Date(strDate);
                return new Food(name, category, price, quantity, date);
            case MUSIC:
                String strGenre = reader.getValue(dataLine,"Gatunek muzyczny");
                boolean video_attached = Boolean.parseBoolean(reader.getValue(dataLine,"Dołączone video"));
                Genre genre = Genre.getGenre(strGenre);
                return new Music(name, category, price, quantity, genre, video_attached);
            case SPORT:
                return new Sport(name, category, price, quantity);
            default:
                return null;
        }
    }

    public Map<String, Object> addExtraProperties(Map<String, Object> map, Item item, Category category){
        switch (category) {
            case BOOKS:
                assert item instanceof Book;
                Book book = (Book) item;
                map.put("Liczba Stron", book.getPage_number());
                map.put("Twarda oprawa", book.getHardCover());
                return map;
            case ELECTRONICS:
                assert item instanceof Electronics;
                Electronics electronics = (Electronics) item;
                map.put("Mobilny", electronics.getMobile());
                map.put("Gwarancja", electronics.getGuarantee());
                return map;
            case FOOD:
                assert item instanceof Food;
                Food food = (Food) item;
                map.put("Data przydatności do spożycia", food.getExpirationDate().getDate());
                return map;
            case MUSIC:
                assert item instanceof Music;
                Music music = (Music) item;
                map.put("Gatunek muzyczny", music.getGenre().getDisplayName());
                map.put("Dołączone video", music.getVideoAttached());
                return map;
            default:
                return map;
        }
    }

    public Item getItemByCategory(Category category){
        switch (category) {
            case BOOKS:
                return new Book();
            case ELECTRONICS:
                return new Electronics();
            case FOOD:
                return new Food();
            case MUSIC:
                return new Music();
            case SPORT:
                return new Sport();
            default:
                return null;
        }
    }
}

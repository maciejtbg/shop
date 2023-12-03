package pl.nauczycielmontessori.shop.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository <Item,Long> {
    List<Item> findByItemType(ItemType itemType);

    List<Item> findItemsByReleaseDateAfterOrderByReleaseDate(LocalDate localDate);

    List<Item> findItemsByPopularityGreaterThanOrderByPopularity(int startingPopularity);

}
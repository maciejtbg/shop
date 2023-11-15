package pl.nauczycielmontessori.shop.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository <Item,Long> {
    List<Item> findByItemType(ItemType itemType);

}
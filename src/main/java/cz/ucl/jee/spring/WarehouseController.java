package cz.ucl.jee.spring;

import cz.ucl.jee.spring.warehouse.WarehouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseDao dao;

    @GetMapping(value = "/warehouse")
    public String itemsInStorage(@RequestParam String itemCode) {
        return String.valueOf(dao.getNumberOfItems(itemCode));
    }

}

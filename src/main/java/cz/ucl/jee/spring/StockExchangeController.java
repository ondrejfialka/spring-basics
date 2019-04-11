package cz.ucl.jee.spring;

import cz.ucl.another.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockExchangeController {

    @Autowired
    StockExchangeService stockExchangeData;

    @GetMapping(value = "/stocks")
    public String getQuote(@RequestParam String company) {

        return stockExchangeData.getQuote(company);
    }


}

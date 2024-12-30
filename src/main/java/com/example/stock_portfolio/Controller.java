package com.example.stock_portfolio;

import com.example.stock_portfolio.Model;
import com.example.stock_portfolio.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class Controller {

    private final StockService stockService;

    @Autowired
    public Controller(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Model> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping
    public Model addStock(@RequestBody Model stock) {
        return stockService.addStock(stock);
    }

    @PutMapping("/{id}")
    public Model updateStock(@PathVariable Long id, @RequestBody Model stock) {
        return stockService.updateStock(id, stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}

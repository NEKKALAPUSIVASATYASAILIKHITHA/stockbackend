package com.example.stock_portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Add this annotation
public class StockService {

    private final SRepository stockRepository;

    @Autowired
    public StockService(SRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Model> getAllStocks() {
        return stockRepository.findAll();
    }

    public Model addStock(Model stock) {
        return stockRepository.save(stock);
    }

    public Model updateStock(Long id, Model stock) {
        if (stockRepository.existsById(id)) {
            stock.setId(id);
            return stockRepository.save(stock);
        }
        return null;
    }

    public void deleteStock(Long id) {
        if (stockRepository.existsById(id)) {
            stockRepository.deleteById(id);
        }
    }
}

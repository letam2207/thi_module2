package bai_thi.service;

import bai_thi.entity.DienThoai;
import bai_thi.repository.DienThoaiRepository;
import bai_thi.repository.IDienThoaiRepository;

import java.util.List;

public class DienThoaiXachTayService implements IDienThoaiXachTayService{
    private static IDienThoaiRepository dienThoaiRepository = new DienThoaiRepository();
    @Override
    public List<DienThoai> findAll() {
        return dienThoaiRepository.findAll();
    }

    @Override
    public void add(DienThoai dienThoai) {
     dienThoaiRepository.add(dienThoai);
    }

    @Override
    public boolean delete(String id) {
        return dienThoaiRepository.delete(id);
    }

    @Override
    public DienThoai findById(String id) {
        return dienThoaiRepository.findById(id);
    }

    @Override
    public List<DienThoai> findBYName(String name) {
        return dienThoaiRepository.findBYName(name);
    }
    public static boolean isIdExist(String id) {
        return dienThoaiRepository.findById(id) != null;
    }
}

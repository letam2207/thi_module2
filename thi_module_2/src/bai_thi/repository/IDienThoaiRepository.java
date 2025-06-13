package bai_thi.repository;

import bai_thi.entity.DienThoai;

import java.util.List;

public interface IDienThoaiRepository {
    List<DienThoai> findAll();

    void add(DienThoai dienThoai);

    boolean delete(String id);

    DienThoai findById(String id);

    List<DienThoai> findBYName(String name);

}

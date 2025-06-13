package bai_thi.repository;

import bai_thi.common.ReadAndWrite;
import bai_thi.entity.DienThoai;
import bai_thi.entity.DienThoaiChinhHang;
import bai_thi.entity.DienThoaiXachTay;

import java.util.ArrayList;
import java.util.List;

public class DienThoaiRepository implements IDienThoaiRepository {
    private static final String DIETHOAI_FILE = "src/bai_thi/data/dienthoai.csv";
    @Override
    public List<DienThoai> findAll() {
        List<DienThoai> xachTayList = new ArrayList<>();
        List<DienThoai> chinhHangList = new ArrayList<>();
        List<String> stringList = ReadAndWrite.readFileCSV(DIETHOAI_FILE);

        for (String s : stringList){
            String[] array = s.split("\\s*,\\s*");

            if (array[0].contains("XT")){
                xachTayList.add(new DienThoaiXachTay(array[0],array[1],Integer.parseInt(array[2]),Integer.parseInt(array[3]),array[4],array[5],array[6]));
            }else if (array[0].contains("CH")){
                chinhHangList.add(new DienThoaiChinhHang(array[0],array[1],Integer.parseInt(array[2]),Integer.parseInt(array[3]),array[4],Integer.parseInt(array[5]),array[6]));
            }
        }
        List<DienThoai> sortedList = new ArrayList<>();
        sortedList.addAll(xachTayList);
        sortedList.addAll(chinhHangList);
        return sortedList;
    }


    @Override
    public void add(DienThoai dienThoai) {
        List<String> stringList = new ArrayList<>();
        if (dienThoai instanceof DienThoaiXachTay) {
            stringList.add((dienThoai).getInfoToFIle());
        } else if (dienThoai instanceof DienThoaiChinhHang) {
            stringList.add((dienThoai).getInfoToFIle());
        }
        ReadAndWrite.writeFileCSV(DIETHOAI_FILE, stringList, true);

    }

    @Override
    public boolean delete(String id) {

        List<DienThoai> dienThoaiList = findAll();
        boolean check = false;
        for (int i = 0; i < dienThoaiList.size(); i++) {
            if (id.equals(dienThoaiList.get(i).getId())) {
                check = true;
                dienThoaiList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (DienThoai p : dienThoaiList) {
            stringList.add(p.getInfoToFIle());
        }
        ReadAndWrite.writeFileCSV(DIETHOAI_FILE, stringList, false);
        return check;
    }

    @Override
    public DienThoai findById(String id) {
        for (DienThoai p : findAll()) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<DienThoai> findBYName(String name) {
        List<DienThoai> dienThoais = findAll();
        List<DienThoai> dienThoaiList = new ArrayList<>();
        for (int i = 0; i < dienThoais.size(); i++) {
            if (dienThoais.get(i).getTen().toLowerCase().contains(name.toLowerCase())) {
                dienThoaiList.add(dienThoais.get(i));
            }
        }
        return dienThoaiList;
    }
}

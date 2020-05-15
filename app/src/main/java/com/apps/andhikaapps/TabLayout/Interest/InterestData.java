package com.apps.andhikaapps.TabLayout.Interest;

import com.apps.andhikaapps.Model.ModelInterest;
import com.apps.andhikaapps.R;

import java.util.ArrayList;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    06 May 2020
 */

class InterestData {

    private static final String[] nama_hobby = {
            "Membaca Komik",
            "Menonton Film"
    };

    private static final int[] img_hobby = {
            R.drawable.ic_comic,
            R.drawable.ic_movie
    };

    static ArrayList<ModelInterest> prepareData(){
        ArrayList<ModelInterest> ArrayData = new ArrayList<>();
        for (int i=0; i<nama_hobby.length; i++){
            ModelInterest modelInterest = new ModelInterest();
            modelInterest.setNama_hobby(nama_hobby[i]);
            modelInterest.setImage_hobby(img_hobby[i]);
            ArrayData.add(modelInterest);
        }
        return ArrayData;
    }
}

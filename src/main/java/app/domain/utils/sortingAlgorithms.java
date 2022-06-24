package app.domain.utils;

import java.util.List;

public class sortingAlgorithms {



    public static CsvFileInfo[] bubbleSort (CsvFileInfo [] list,String sortType){

        for (int i = 0; i < list.length - 1 ; i++) {
            for (int j = 0; j < list.length - 1 ; j++) {

                if(list[j+1].getDate(sortType).before(list[j].getDate(sortType))){

                    CsvFileInfo info = list[j];
                    list [j] = list[j+1];
                    list [j+1] = info;


                }

            }


        }

        return list;
    }


    public static CsvFileInfo [] insertionSort (CsvFileInfo [] list,String sortType){

        for (int i = 0; i < list.length; i++) {

            CsvFileInfo aux = list[i];
            int j = i - 1;

            while (j >= 0 && list[j].getDate(sortType).after(aux.getDate(sortType))){

                list[j + 1] = list [j];
                j = j - 1;

            }

            list [j + 1] = aux;

        }

        return list;

    }



}

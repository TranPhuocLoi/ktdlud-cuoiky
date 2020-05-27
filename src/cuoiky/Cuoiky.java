/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuoiky;

import java.io.File;
import java.io.FileWriter;
import static java.lang.Math.log;
import static java.time.Clock.system;
import weka.core.converters.ArffSaver;

/**
 *
 * @author nudo350
 */
public class Cuoiky {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        MyKnowledgeModel new_model=new MyKnowledgeModel("C:\\Program Files\\Weka-3-8-4\\data\\qualitywine.arff");
//        System.out.println(new_model);
//        new_model.saveDataToCSV("D:\\ocela.csv");
//            MyKnowledgeModel new_model = new MyKnowledgeModel("C:\\Program Files\\Weka-3-8-4\\data\\qualitywine.arff",null, null);
//              new_model.trainset = new_model.divideTrainTest(new_model.dataset,20, false );
//              new_model.testset = new_model.divideTrainTest(new_model.dataset,20, true );
//              System.out.println(new_model);
//              System.out.println(new_model.trainset.toSummaryString());
//              System.out.println(new_model.testset.toSummaryString());

             MyKnowledgeModel new_model = new MyKnowledgeModel("C:\\Program Files\\Weka-3-8-4\\data\\qualitywine.arff",null, null);
              new_model.trainset = new_model.divideTrainTestR(new_model.dataset,80, false );
              new_model.testset = new_model.divideTrainTestR(new_model.dataset,80, true );
              System.out.println(new_model);
              System.out.println(new_model.trainset.toSummaryString());
              System.out.println(new_model.testset.toSummaryString());
              //Export file arff from data testset
              ArffSaver exportData = new ArffSaver();
              exportData.setInstances(new_model.trainset);
              exportData.setFile(new File("D:\\Document\\UIT\\2019-2020\\KTDLUD\\cuoiky\\trainset.arff"));
              exportData.writeBatch();
   }
}

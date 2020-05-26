/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuoiky;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.RemovePercentage;
import weka.filters.unsupervised.instance.Resample;

/**
 *
 * @author nudo350
 */
public class MyKnowledgeModel {
    DataSource source;
    Instances dataset;
    Instances trainset;
    Instances testset;
    String[] model_options;
    String[] data_options;
    
    public MyKnowledgeModel(){
        
    }
    public MyKnowledgeModel( String filename, String m_opts, String d_opts) throws Exception{
        this.source =  new DataSource(filename);
        this.dataset = source.getDataSet();
        if(m_opts != null){
            this.model_options = weka.core.Utils.splitOptions(m_opts);
        }
        if(d_opts != null){
            this.data_options = weka.core.Utils.splitOptions(d_opts);
        }
    }

    MyKnowledgeModel(String cProgram_FilesWeka384dataqualitywinearff, Object object, Object object0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void saveData(String filename) throws IOException{
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename)); 
        outData.writeBatch();
        System.out.println("Saving Finished");
    }
    
     public void saveDataToCSV(String filename) throws IOException{
        CSVSaver outData = new CSVSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename)); 
        outData.writeBatch();
        System.out.println("Converted to CSV success");
    }
    
     public Instances divideTrainTest( Instances originalSet, double percent, boolean isTest)throws Exception{
         RemovePercentage rp = new RemovePercentage();
         rp.setPercentage(percent);
         rp.setInvertSelection(isTest);
         rp.setInputFormat(originalSet);
         return Filter.useFilter(originalSet, rp);
     }
     
     public Instances divideTrainTestR( Instances originalSet, double percent, boolean isTest)throws Exception{
         Resample rs = new Resample();
         rs.setNoReplacement(true);
         rs.setSampleSizePercent(percent);
         rs.setInvertSelection(isTest);
         rs.setInputFormat(originalSet);
         return Filter.useFilter(originalSet, rs);
     }
     
    @Override
    public String toString() {
        return dataset.toSummaryString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

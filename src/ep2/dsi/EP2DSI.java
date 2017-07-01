
package ep2.dsi;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class EP2DSI {
    
    //Tutorial
    
    //Mapper
    
    //Pelo que eu entendi, ele recebe uma linha do arquivo e apenas separa as palavras a cada espaco e associa o 1 para cada palavra
    //repassando ao hadoop o par <valor, chave>
    //Seguir o layout que tem no readme na pasta dos dados
     public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        //Repassa o valor e sua chave ao sistema do hadoop
        //No nosso caso seria o tipo de dado (ex: SPD) com o agrupamento (ano do dado) escolhidos pelo usuario.
        //Ex: <67.0,1998>
        context.write(word, one);
      }
    }
  }
    
    //Reducer 
     
    //Vai receber um conjunto de dados com a chave em comum (ex: todos os todos de VISIB do ano de 1984) 
    public static class IntSumReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      //Devolve um resultado para o conjunto de entrada
      context.write(key, result);
    }
  }

    //Tutorial
    
    public static void main(String[] args) throws Exception {
        UI ui = new UI();
        ui.run();
        
        //Tutorial
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "EP2");
        job.setJarByClass(EP2DSI.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        //Tutorial
                
    }
    
}

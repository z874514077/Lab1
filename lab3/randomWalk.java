package lab3;

import java.util.Random;
import java.util.Scanner;

public class randomWalk {
	 public String randomWalk(){    //�޳��Ȼ�ڶ��ΰݷ�ʱֹͣ
	    	System.out.println("������������ߵ���㣺");
	    	Scanner sc1 = new Scanner(System.in);
	    	String start = sc1.nextLine();
	    	String randomText = "";
	    	String[] randomArray = new String[numOfEdges]; // ·���������
	    	for(int i = 0;i<numOfEdges;i++){   //��ʼ��
	    		randomArray[i] = "";
	    	}
	    	randomText =randomText + start + " ";   //�����ŵ�randomtext��ͷ
	    	int sp = getPosition(start);            //��ȡ���λ��
	    	int randomflag = sp;                    //ѭ������
	    	int arraynum = 0;                       // randomArray������±�'
	    	sc1.close();
	    	if (sp == -1)                           //��һ���������㲻����
	    		return "condition";
	    	
	    	for(int i = 0;i<numOfEdges;i++){
	    		int[] neighbor = allNeighbor(randomflag);   //��ȡ���ӵ�������һ���ٽ��
	    		int num1000 = 0;
	    		for(int j = 0;j<vexs.length;j++){
	    			if(neighbor[j]==1000){
	    				num1000++;}
	    		}
	    		int rf = randomflag;
	            if(neighbor[0]==-1){                        // �ڶ�����������һ���ٽ��Ϊ-1����û����һ���ٽ��
	            	break;}                    // ֹͣ
	            else{
	            	Random random = new Random();
	    		    int s = Math.abs(random.nextInt()%(neighbor.length-num1000));  //��������
	    		    randomflag = neighbor[s];//�����һ������
	  		        int[] pos = new int[numOfEdges];// ���randomflag��randomArray������λ�õ�����position
	  		        int posnum = 0;
			        for(int j = 0;j<numOfEdges;j++){
			        	if(randomArray[j].equals(vexs[randomflag])){
			        		pos[posnum] = j;
			        		posnum++;
			        	}
			        }
			        for(int k = 0;k<numOfEdges;k++){
			        	if(pos[k]!=0 && vexs[rf].equals(randomArray[pos[k]-1])){//���������ӵ�ǰһ���ڵ�Ϊ��һ������
			        		randomText =randomText +vexs[neighbor[s]] + " ";  //�����ַ���
			        		return randomText;                           //����� �ظ�
			        	}
			        }
	    		    randomArray[arraynum] = vexs[neighbor[s]];        //��������
	    		    arraynum++;
	    		    randomText =randomText +vexs[neighbor[s]] + " ";  //�����ַ���
	    		    } 
	            }
	    	return randomText;
	    }
}

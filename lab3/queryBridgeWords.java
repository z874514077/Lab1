package lab3;

public class queryBridgeWords {
	 //��ѯ�ŽӴ�
    public String queryBridgeWords(String word1, String word2){  //����string situation
    	int p1 = getPosition(word1);
    	int p2 = getPosition(word2);
    	if(p1== -1 && p2 == -1)
    		return("situation1");
    	else if (p1== -1 && p2 != -1)
    		return("situation2");
    	else if (p1!= -1 && p2 == -1)
    		return("situation3");
    	else{
    		int first = getFirstNeighbor(p1);    //�ҵ�word1�ĵ�һ���ڽӵ�
    		int[] next = new int[vexs.length];   // next������ word1���ڽӵ�
    		int num = 1;    //next�����±�
    		next[0] =  first;   // �ѵ�һ���ٽ��ŵ�����
    		for(int i = 1;i<vexs.length;i++){  //����ӵڶ�����ʼ
    			next[i] = 1000;
    			if(getNextNeighbor(p1,next[num-1])!= -1){  //������� 
    			     next[num] = getNextNeighbor(p1,next[num-1]); //word1 �� num-1����һ���ڽӵ�
    		         num++;
    			}
    		}
    		int sum = -1;    // bridge�����±�
    		String[] bridge = new String[num];   //bridge����������������ĵ�
           	String ans = "";    //���з����������ƴ���ַ���
           	
    		for(int i = 0;i<bridge.length;i++){
    			bridge[i] = "";  //��ʼ��һ��
   			    int nextfirst = getFirstNeighbor(next[i]);  //nextfirst Ϊnext[i]�ĵ�һ���ڽӵ�
                int[] nextnext = new int[vexs.length];      // next[i]���ڽӵ�����nextnext
                nextnext[0] = nextfirst;  //nextfirstΪ��һ��
                int nextnum = 1;   //nextnext�����±�
                for(int j = 1;j<vexs.length;j++){  //����ӵڶ�����ʼ
                	nextnext[j]= 1000;
                	if(getNextNeighbor(next[j],nextnext[nextnum-1])!= -1){  //�������
       			     nextnext[nextnum] = getNextNeighbor(next[j],nextnext[nextnum-1]); //��һ���ڽӵ�
       			     nextnum++;}
                }
                
                for(int k = 0;k<nextnext.length;k++){
                	if (nextnext[k] == p2){
                		sum++;//������һ
                		bridge[sum] = vexs[next[i]];     //�м�����bridge
                    }	
    		    }  
            }  
    		
            if (sum == -1)   //�������Ϊ0
                return("situation4");
            else{
                for(int x = 0;x<bridge.length;x++){
                	if(bridge[x].equals("")==false){
                		ans = ans + bridge[x];
                		ans = ans + " ";}
                	}
                return ans;
    	    }
            
    	}
    }
}

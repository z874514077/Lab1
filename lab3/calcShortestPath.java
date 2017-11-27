package lab3;

public class calcShortestPath {
	//�������·��=====================================================================================
    public String printPath(int[][] path,int from, int to) {
    	  String shortText = "";
          while(path[from][to]!=from && path[from][to]!=-1){
        	   shortText = shortText + vexs[path[from][to]]+" ";
               to = path[from][to];
           }  
          return shortText;
     }     
     //path -- ·����path[i][j]=k��ʾ��"����i"��"����j"�����·���ᾭ������k��
     //dist -- �������顣����dist[i][j]=sum��ʾ��"����i"��"����j"�����·���ĳ�����sum��
    
    public String calcShortestPath(String word1, String word2) {
        int[][] path = new int[numOfVexs][numOfVexs];
        int[][] dist = new int[numOfVexs][numOfVexs];
        int p1 = getPosition(word1);// word1λ��
        int p2 = getPosition(word2);//word2λ��
        // ��ʼ��
        for (int i = 0; i < numOfVexs; i++) {
            for (int j = 0; j < numOfVexs; j++) {
                dist[i][j] = edges[i][j];    // "����i"��"����j"��·������Ϊ"i��j��Ȩֵ"��
                path[i][j] = -1;                // "����i"��"����j"�����·���Ǿ�������j��
            }
        }
     // �������·��
        for (int k = 0; k < numOfVexs; k++) {
            for (int i = 0; i <numOfVexs; i++) {
                for (int j = 0; j < numOfVexs; j++) {
                    // ��������±�Ϊk����·����ԭ�����·�����̣������dist[i][j]��path[i][j]
                    int tmp = (dist[i][k]==INF || dist[k][j]==INF) ? INF : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp) {
                        // "i��j���·��"��Ӧ��ֵ�裬Ϊ��С��һ��(������k)
                        dist[i][j] = tmp;
                        // "i��j���·��"��Ӧ��·��������k
                        path[i][j] = k;
                    }
                }
            }
        }
        String shortText = printPath(path,p1,p2);
        return shortText+dist[p1][p2];
    }
}

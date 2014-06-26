package garage;

/**
 * 0/1 kanpsack problem: Given a set of items, each with a weight and a value,
 * determine the number of each item to include in a collection so that the
 * total weight is less than or equal to a given limit (capacity of knapsack)
 * and the total value is as large as possible, using dynamic programming
 * @author Rocky
 */
public class Knapsack
{
  //capacity of knapsack
  private int c;
  //weight of item
  private int[] w;
  //value of item
  private int[] v;
  //dynamic programming matrix
  private int[][] m;
  //result of  best solution
  private int[] s;
  //maximum value
  private int maxV;

  /**
   * Constructor
   * @param _w: repair hours array for cars
   * @param _v: repair prices array corresponding to repair hours array
   * @param _c: available hours for repairing cars
   */
  public Knapsack(int[] _w, int[] _v, int _c)
  {
    this.w = _w;
    this.v = _v;
    this.c = _c;
    m = new int[w.length][c + 1];
    s = new int[w.length];
  }

  /**
   * get maximum value using dynamic programming
   */
  public void dynamicExecute()
  {
    initMatrix();
    for (int i = 1; i < m.length; i++)
    {
      for (int j = 1; j < m[i].length; j++)
      {
        if (j < w[i])  //do not take item i
        {
          m[i][j] = m[i - 1][j];
        } else  // take item i, select the better one
        {
          m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i]] + v[i]);
        }
      }
    }
    maxV = m[m.length - 1][c];
  }

  /**
   * initialize the matrix
   */
  private void initMatrix()
  {
    for (int i = 0; i < m.length; i++)
    {
      m[i][0] = 0;
    }
    for (int j = 0; j < m[0].length; j++)
    {
      if (w[0] <= j)
      {
        m[0][j] = v[0];
      } else
      {
        m[0][j] = 0;
      }
    }
  }

  /**
   * get the knapsack solution according to the matrix
   */
  public int[] getResult()
  {
    int tmp = c;
    int i;
    for (i = m.length - 1; i > 0; i--)
    {
      if (m[i][tmp] == m[i - 1][tmp])
      {
        s[i] = 0;
      } else
      {
        s[i] = 1;
        tmp = tmp - w[i];
      }
    }
    s[i] = (m[0][tmp] != 0) ? 1 : 0;

    return s;
  }

  /**
   * print the dynamic programming matrix
   */
  public void printMatrix()
  {
    for (int i = 0; i < m.length; i++)
    {
      for (int j = 0; j < m[i].length; j++)
      {
        System.out.print(m[i][j] + " ");
      }
      System.out.println();
    }
  }
  /**
   *
   * @return max value of knapsack solution
   */
  public int getMaxValue()
  {
    return maxV;
  }
}

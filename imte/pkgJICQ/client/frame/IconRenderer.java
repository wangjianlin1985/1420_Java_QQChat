package pkgJICQ.client.frame;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

//��ͼ��������ĵ�Ԫ������,��JLabel����չ,ʵ��ListCellRenderer�ӿ�

public class IconRenderer extends JLabel implements ListCellRenderer
{

   public Component getListCellRendererComponent(JList list, Object obj, int row, boolean sel, boolean hasFocus) 
   {
      Object[] cell = (Object[])obj;   //�õ��еĲ���
      setIcon((Icon)cell[0]);  //����ͼ��
      //insertIcon((Icon)cell[0]);
      this.setText(cell[1].toString()); //�����ı�
      
      setFont(new Font("����",Font.ROMAN_BASELINE,12));
      setToolTipText(cell[2].toString());  //������ʾ�ı�
    //  setBorder(new LineBorder(Color.WHITE)); //���ñ߽�
      
      
      if (sel)
      {
        setForeground(Color.MAGENTA);  //���ѡ����,�����ı���ɫΪƷ��ɫ
      }
      else
      {
        setForeground(list.getForeground()); //���δѡ��,�����ı���ɫΪĬ��ɫ
      }
      return this;
   }
}
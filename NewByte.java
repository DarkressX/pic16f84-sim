public class NewByte
{
    private short dataField;

    public void setDataField(short data) throws IllegalArgumentException
    {
        if(!(data >= 0 && data < 256))
        {
            throw new IllegalArgumentException("Register Value out of Range");
        }
        dataField = (data);
    }

    public int getDataField()
    {
        return dataField;
    }
}

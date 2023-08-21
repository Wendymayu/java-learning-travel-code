package com.wendy.poi;

import com.wendy.poi.pojo.Customer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/4 20:48
 * @Version 1.0
 */
public class CustomerExcelUtil {
    public static void exportExcel(List<Customer> customers) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet1 = workbook.createSheet("customers");
        Row row1 = sheet1.createRow(0);

        // 创建表头
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("顾客表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet1.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));

        // 创建表头行
        Row row2 = sheet1.createRow(1);
        row2.createCell(0).setCellValue("ID");
        row2.createCell(1).setCellValue("姓名");
        row2.createCell(2).setCellValue("详细地址");
        row2.createCell(3).setCellValue("城市");
        row2.createCell(4).setCellValue("省");
        row2.createCell(5).setCellValue("国家");
        row2.createCell(6).setCellValue("邮编");
        row2.createCell(7).setCellValue("联系方式");
        row2.createCell(8).setCellValue("邮箱");

        //创建内容行
        int i = 2;
        for (Customer customer : customers) {
            Row row = sheet1.createRow(i);
            row.createCell(0).setCellValue(customer.getCustId());
            row.createCell(1).setCellValue(customer.getCustName());
            row.createCell(2).setCellValue(customer.getCustAddress());
            row.createCell(3).setCellValue(customer.getCustCity());
            row.createCell(4).setCellValue(customer.getCustState());
            row.createCell(5).setCellValue(customer.getCustCountry());
            row.createCell(6).setCellValue(customer.getCustZip());
            row.createCell(7).setCellValue(customer.getCustContact());
            row.createCell(8).setCellValue(customer.getCustEmail());
            i++;
        }

        //写入到文件
        File file = new File("customer.xlsx");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            System.out.println("导出文档成功");
        } catch (FileNotFoundException e) {
            System.out.println("未找到文件");
        } catch (IOException e) {
            System.out.println("导出文件失败");
        }
    }

    public static List<Customer> customersFromExcel() throws IOException {
        String path = "excel/customer.xlsx";
        ClassPathResource resource = new ClassPathResource(path);
        InputStream inputStream = resource.getInputStream();
        Workbook workbook;
        if (path.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            workbook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet1 = workbook.getSheet("customers");
        List<Customer> customerList = new ArrayList<>();
        for (int i = 2; i < sheet1.getLastRowNum(); i++) {
            Customer customer = new Customer();
            Row row = sheet1.getRow(i);
            customer.setCustId(Integer.parseInt(getStringValue(row.getCell(0))));
            customer.setCustName(getStringValue(row.getCell(1)));
            customer.setCustAddress(getStringValue(row.getCell(2)));
            customer.setCustCity(getStringValue(row.getCell(3)));
            customer.setCustState(getStringValue(row.getCell(4)));
            customer.setCustState(getStringValue(row.getCell(5)));
            customer.setCustCountry(getStringValue(row.getCell(6)));
            customer.setCustZip(getStringValue(row.getCell(7)));
            customer.setCustEmail(getStringValue(row.getCell(8)));
            customerList.add(customer);
        }
        inputStream.close();
        return customerList;
    }


    /**
     * create by: wendyMa
     * description: 先从单元格中统一返回字符串数据；如果不用该方法，数据类型转换很讨厌
     * create time: 2022/3/5 7:04
     *
     * @return
     */
    private static String getStringValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        CellType cellType = cell.getCellType();
        switch (cellType) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                double value = cell.getNumericCellValue();
                return String.valueOf(Math.round(value));
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return null;
        }
    }
}

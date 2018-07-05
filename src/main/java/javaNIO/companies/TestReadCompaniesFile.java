package javaNIO.companies;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestReadCompaniesFile {
    public static void main(String[] args) {
        Path file = Paths.get("D:\\project\\data\\companies_big_data.csv");
        /*System.out.println(file.getFileName());
        String name = file.getFileName().toString();
        String[] fullFileName = name.split("\\.");
        String typeFile = fullFileName[1];
        System.out.println(typeFile);*/

        try (InputStream in = Files.newInputStream(file)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            List<String> list = new ArrayList<>();
            while ((line = reader.readLine())!=null){
                list.add(line);
            }
            list.remove(0);
            List<Company> companyList = new ArrayList<>();
            for (String itemOfList : list){
                Company company = new Company();
                String[] items = itemOfList.split("\\,");
                company.setId(items[0]);
                company.setName(items[1]);
                company.setFoundationDate(items[2]);
                company.setCapital(Integer.parseInt(items[3]));
                company.setCountry(items[4]);
                if (items.length == 6){
                    company.setHeadquarterId(items[5]);
                }else{
                    company.setHeadquarterId(null);
                }
                companyList.add(company);
            }
            System.out.println(companyList.toString());
//            System.out.println(companyList.stream().filter(p->p.getCountry().equals("CH")).mapToInt(Company::getCapital).sum());
//            System.out.println("-----------------");
//            System.out.println(companyList.stream().filter(p->p.getCountry().equals("IT")).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

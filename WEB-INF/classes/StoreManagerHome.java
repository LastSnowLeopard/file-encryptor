import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
@WebServlet("/StoreManagerHome")
public class StoreManagerHome extends HttpServlet {

    private String error_msg;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        displayStoreManagerHome(request, response, pw, "");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Utilities utility = new Utilities(request, pw);
         //Add New product
         Map<String, Object> map = new HashMap<String, Object>();
         String catalog;
        }
    private void displayStoreManagerHome(HttpServletRequest request,HttpServletResponse response, PrintWriter pw, String flag)
    {

        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("LeftNavigationBar.html");

        pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<h3 class='title'>");
        pw.print("Create New product");
        pw.print("</h3>");
        pw.print("<div class='entry'>");

        if (flag.equals("newProduct"))
        pw.print("<h4 style='color:red'>" + error_msg + "</h4>");
        //////////////////////////////////////
        pw.print("<form action='CreateProduct' method='post'>");
        pw.print("<table class='gridtable'>");

        pw.print("<tr><td>Product ID:</td>");

        pw.print("<td><input type='text' name='productId' value=''></td>");
        pw.print("</tr>");
        

        pw.print("<tr><td>Product Name</td><td><input type='text' name='productName' value='' class='input' required></td></tr>");
        

        pw.print("<tr><td>Product Catalog</td><td><select id='catalog' name='productCatalog' class='input'>" +
        "<option value='fitness' name='fitness'selected>Fitness watch</option>" +
        "<option value='smartwatch' name='smartwatch'>Smart watch</option>" +
        "<option value='headphones' name='headphones'>Headphone</option>" +
        "<option value='tv' name='tv'>TV</option>" +
        "<option value='soundsystem' name='soundsystem'>Sound System</option>" +
        "<option value='phone' name='phone'>Phone</option>" +
        "<option value='laptop' name'laptop'>Laptop</option>" +
        "<option value='voiceassistant' name='voiceassistant'>VoicesAssistant</option>" +
        "<option value='voiceassistant' name='accessory'>Accessory</option>"
        );
        pw.print("</select></td></tr>");


        pw.print("<tr><td>Price</td><td><input type='text' name='price' value='' class='input' required></td></tr>");
        //pw.print("<h4>Manufacturer</h4></td><td><input type='text' name='manufacturer' value='" + manufacturer + "' class='input' required></input>");
        //pw.print("</td></tr><tr><td>");

        pw.print("<tr><td>Condition</td><td><select name='condition' class='input'>" +
        "<option value='New' selected>New</option>" +
        "<option value='Used'>Used</option>" +
        "<option value='Refurbished'>Refurbished</option></select></td></tr>");
        

        pw.print("<tr><td>Image</td><td><img id=\"preview\" /><br/><input type='file' name='image' class='input' required></td></tr>");
        

        pw.print("<tr><td>Discount</td><td><input type='text' name='discount' value='' class='input' required></td></tr>");
        

        pw.print("<tr><td><input type='submit' class='btnbuy' value='Create' style='float: left;height: 20px margin: 20px; margin-right: 10px;'></td></tr>");
        //pw.print("</td></tr><tr><td></td><tr>");
        pw.print("</table></form></div></div>");
        //pw.print("</div>");


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




        pw.print("<div class='post'>");
        // pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<h2 class='title meta'>");
        pw.print("<a style='font-size: 24px;'>View Products</a></h2>");
        pw.print("<div class='entry'>");
        pw.print("<table class='gridtable'>");

        if (flag.equals("RemoveUpdateProduct"))
        pw.print("<h4 style='color:red'>" + error_msg + "</h4>");



        //        pw.print("<div align='left' style='float:left'>");
        //        pw.print("<input type='submit' name='Product' value='Update Product' class='btnbuy'>");
        //        pw.print("</div>");
        //        pw.print("<div align='right'>");
        //        pw.print("<input type='submit' name='Product' value='Remove Product' class='btnbuy'>");
        //        pw.print("</div>");
        //        pw.print("<br>");



        pw.print("<tr>");
        pw.print("<td>Product Name</td>");
        pw.print("<td>Price</td>");
        //  pw.print("<td>Manufacturer</td>");
        pw.print("<td>Condition</td>");
        pw.print("<td>Discount</td>");
        pw.print("<td>Catalog</td>");
        pw.print("</tr>");


        for (Map.Entry<String, FitnessWatch> entry : SaxParserDataStore.fitnesswatches.entrySet()) {
        FitnessWatch fitness = entry.getValue();
        pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<tr>");
        //            pw.print("<td><input type='radio' name='productId' value='" + fitness.getId() + "'></td>");

        pw.print("<td>" + fitness.getName() + "</td>" +
        "<td>" + fitness.getPrice() + "</td>" +
        // "<td>" + fitness.getRetailer() + "</td>" +
        "<td>" + fitness.getCondition() + "</td>" +
        "<td>" + fitness.getDiscount() + "</td>" +
        "<td>Fitness Watch</td>");

        pw.print("<input type='hidden' name='productId' value='" + fitness.getId() + "'>");
        pw.print("<input type='hidden' name='productName' value='" + fitness.getName() + "'>");
        pw.print("<input type='hidden' name='price' value='" + fitness.getPrice() + "'>");
        // pw.print("<input type='hidden' name='manufacturer' value='" + fitness.getRetailer() + "'>");
        pw.print("<input type='hidden' name='condition' value='" + fitness.getCondition() + "'>");
        pw.print("<input type='hidden' name='discount' value='" + fitness.getDiscount() + "'>");
        pw.print("<input type='hidden' name='productCatalog' value='fitness'>");
        pw.print("<input type='hidden' name='image' value='" + fitness.getImage() + "'>");
        pw.print("</tr>");

        pw.print("<tr>");
        pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
        pw.print("<td>");
        pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        pw.print("</tr>");
        pw.print("</form>");
        //pw.print("<br>");
        }


        for (Map.Entry<String, SmartWatch> entry : SaxParserDataStore.smartwatches.entrySet()) {
        SmartWatch smartwatch = entry.getValue();
        pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<tr>");
        //pw.print("<td><input type='radio' name='productId' value='" + smartwatch.getId() + "'></td>");

        pw.print("<td>" + smartwatch.getName() + "</td>" +
        "<td>" + smartwatch.getPrice() + "</td>" +
        //"<td>" + smartwatch.getRetailer() + "</td>" +
        "<td>" + smartwatch.getCondition() + "</td>" +
        "<td>" + smartwatch.getDiscount() + "</td>" +
        "<td>Smart Watch</td>");
        pw.print("<input type='hidden' name='productId' value='" + smartwatch.getId() + "'>");
        pw.print("<input type='hidden' name='productName' value='" + smartwatch.getName() + "'>");
        pw.print("<input type='hidden' name='price' value='" + smartwatch.getPrice() + "'>");
        //    pw.print("<input type='hidden' name='manufacturer' value='" + smartwatch.getRetailer() + "'>");
        pw.print("<input type='hidden' name='condition' value='" + smartwatch.getCondition() + "'>");
        pw.print("<input type='hidden' name='discount' value='" + smartwatch.getDiscount() + "'>");
        pw.print("<input type='hidden' name='productCatalog' value='smartwatch'>");
        pw.print("<input type='hidden' name='image' value='" + smartwatch.getImage() + "'>");
        pw.print("</tr>");

        pw.print("<tr>");
        pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
        pw.print("<td>");
        pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        pw.print("</tr>");
        pw.print("</form>");
        }


        for (Map.Entry<String, HeadPhone> entry : SaxParserDataStore.headphones.entrySet()) {
        HeadPhone headphone = entry.getValue();
        pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<tr>");
        //pw.print("<td><input type='radio' name='productId' value='" + headphone.getId() + "'></td>");

        pw.print("<td>" + headphone.getName() + "</td>" +
        "<td>" + headphone.getPrice() + "</td>" +
        //     "<td>" + headphone.getRetailer() + "</td>" +
        "<td>" + headphone.getCondition() + "</td>" +
        "<td>" + headphone.getDiscount() + "</td>" +
        "<td>Headphones</td>");
        pw.print("<input type='hidden' name='productId' value='" + headphone.getId() + "'>");
        pw.print("<input type='hidden' name='productName' value='" + headphone.getName() + "'>");
        pw.print("<input type='hidden' name='price' value='" + headphone.getPrice() + "'>");
        //  pw.print("<input type='hidden' name='manufacturer' value='" + headphone.getRetailer() + "'>");
        pw.print("<input type='hidden' name='condition' value='" + headphone.getCondition() + "'>");
        pw.print("<input type='hidden' name='discount' value='" + headphone.getDiscount() + "'>");
        pw.print("<input type='hidden' name='productCatalog' value='headphone'>");
        pw.print("<input type='hidden' name='image' value='" + headphone.getImage() + "'>");
        pw.print("</tr>");
        pw.print("<tr>");
        pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
        pw.print("<td>");
        pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        pw.print("</tr>");
        pw.print("</form>");
        }


        for (Map.Entry<String, Tv> entry : SaxParserDataStore.tvs.entrySet()) {
        Tv tv = entry.getValue();
        pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<tr>");
        // pw.print("<td><input type='radio' name='productId' value='" + vr.getId() + "'></td>");
        pw.print("<td>" + tv.getName() + "</td>" +
        "<td>" + tv.getPrice() + "</td>" +
        //  "<td>" + tv.getRetailer() + "</td>" +
        "<td>" + tv.getCondition() + "</td>" +
        "<td>" + tv.getDiscount() + "</td>" +
        "<td>tv</td>");
        pw.print("<input type='hidden' name='productId' value='" + tv.getId() + "'>");
        pw.print("<input type='hidden' name='productName' value='" + tv.getName() + "'>");
        pw.print("<input type='hidden' name='price' value='" + tv.getPrice() + "'>");
        //  pw.print("<input type='hidden' name='manufacturer' value='" + tv.getRetailer() + "'>");
        pw.print("<input type='hidden' name='condition' value='" + tv.getCondition() + "'>");
        pw.print("<input type='hidden' name='discount' value='" + tv.getDiscount() + "'>");
        pw.print("<input type='hidden' name='productCatalog' value='tv'>");
        pw.print("<input type='hidden' name='image' value='" + tv.getImage() + "'>");
        pw.print("</tr>");
        pw.print("<tr>");
        pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
        pw.print("<td>");
        pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        pw.print("</tr>");
        pw.print("</form>");
        }

        //Sound System
        for (Map.Entry<String, SoundSystem> entry : SaxParserDataStore.soundsystems.entrySet()) {
        SoundSystem soundsystem = entry.getValue();
        pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<tr>");
        // pw.print("<td><input type='radio' name='productId' value='" + petTracker.getId() + "'></td>");

        pw.print("<td>" + soundsystem.getName() + "</td>" +
        "<td>" + soundsystem.getPrice() + "</td>" +
        //      "<td>" + soundsystem.getRetailer() + "</td>" +
        "<td>" + soundsystem.getCondition() + "</td>" +
        "<td>" + soundsystem.getDiscount() + "</td>" +
        "<td>Sound System</td>");
        pw.print("<input type='hidden' name='productId' value='" + soundsystem.getId() + "'>");
        pw.print("<input type='hidden' name='productName' value='" + soundsystem.getName() + "'>");
        pw.print("<input type='hidden' name='price' value='" + soundsystem.getPrice() + "'>");
        //  pw.print("<input type='hidden' name='manufacturer' value='" + soundsystem.getRetailer() + "'>");
        pw.print("<input type='hidden' name='condition' value='" + soundsystem.getCondition() + "'>");
        pw.print("<input type='hidden' name='discount' value='" + soundsystem.getDiscount() + "'>");
        pw.print("<input type='hidden' name='productCatalog' value='soundsystem'>");
        pw.print("<input type='hidden' name='image' value='" + soundsystem.getImage() + "'>");
        pw.print("</tr>");
        pw.print("<tr>");
        pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
        pw.print("<td>");
        pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        pw.print("</tr>");
        pw.print("</form>");
        }

        //Phone
        for (Map.Entry<String, Phone> entry : SaxParserDataStore.phones.entrySet()) {
        Phone phone = entry.getValue();
        pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<tr>");
        // pw.print("<td><input type='radio' name='productId' value='" + phone.getId() + "'></td>");

        pw.print("<td>" + phone.getName() + "</td>" +
        "<td>" + phone.getPrice() + "</td>" +
        //  "<td>" + phone.getRetailer() + "</td>" +
        "<td>" + phone.getCondition() + "</td>" +
        "<td>" + phone.getDiscount() + "</td>" +
        "<td>Phone</td>");
        pw.print("<input type='hidden' name='productId' value='" + phone.getId() + "'>");
        pw.print("<input type='hidden' name='productName' value='" + phone.getName() + "'>");
        pw.print("<input type='hidden' name='price' value='" + phone.getPrice() + "'>");
        //  pw.print("<input type='hidden' name='manufacturer' value='" + phone.getRetailer() + "'>");
        pw.print("<input type='hidden' name='condition' value='" + phone.getCondition() + "'>");
        pw.print("<input type='hidden' name='discount' value='" + phone.getDiscount() + "'>");
        pw.print("<input type='hidden' name='productCatalog' value='phone'>");
        pw.print("<input type='hidden' name='image' value='" + phone.getImage() + "'>");
        pw.print("</tr>");
        pw.print("<tr>");
        pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
        pw.print("<td>");
        pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        pw.print("</tr>");
        pw.print("</form>");
        }

        //Laptop
        for (Map.Entry<String, Laptop> entry : SaxParserDataStore.laptops.entrySet()) {
        Laptop laptop = entry.getValue();
        pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<tr>");
        //pw.print("<td><input type='radio' name='productId' value='" + laptop.getId() + "'></td>");

        pw.print("<td>" + laptop.getName() + "</td>" +
        "<td>" + laptop.getPrice() + "</td>" +
        //  "<td>" + laptop.getRetailer() + "</td>" +
        "<td>" + laptop.getCondition() + "</td>" +
        "<td>" + laptop.getDiscount() + "</td>" +
        "<td>Laptop</td>");
        pw.print("<input type='hidden' name='productId' value='" + laptop.getId() + "'>");
        pw.print("<input type='hidden' name='productName' value='" + laptop.getName() + "'>");
        pw.print("<input type='hidden' name='price' value='" + laptop.getPrice() + "'>");
        // pw.print("<input type='hidden' name='manufacturer' value='" + laptop.getRetailer() + "'>");
        pw.print("<input type='hidden' name='condition' value='" + laptop.getCondition() + "'>");
        pw.print("<input type='hidden' name='discount' value='" + laptop.getDiscount() + "'>");
        pw.print("<input type='hidden' name='productCatalog' value='laptop'>");
        pw.print("<input type='hidden' name='image' value='" + laptop.getImage() + "'>");
        pw.print("</tr>");
        pw.print("<tr>");
        pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
        pw.print("<td>");
        pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        pw.print("</tr>");
        pw.print("</form>");
        }

        //Voice Assistant
        for (Map.Entry<String, VoiceAssistant> entry : SaxParserDataStore.voiceassistants.entrySet()) {
        VoiceAssistant voiceassistant = entry.getValue();
        pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<tr>");
        // pw.print("<td><input type='radio' name='productId' value='" + Speaker.getId() + "'></td>");

        pw.print("<td>" + voiceassistant.getName() + "</td>" +
        "<td>" + voiceassistant.getPrice() + "</td>" +
        //  "<td>" + voiceassistant.getRetailer() + "</td>" +
        "<td>" + voiceassistant.getCondition() + "</td>" +
        "<td>" + voiceassistant.getDiscount() + "</td>" +
        "<td>Speakers</td>");
        pw.print("<input type='hidden' name='productId' value='" + voiceassistant.getId() + "'>");
        pw.print("<input type='hidden' name='productName' value='" + voiceassistant.getName() + "'>");
        pw.print("<input type='hidden' name='price' value='" + voiceassistant.getPrice() + "'>");
        //pw.print("<input type='hidden' name='manufacturer' value='" + voiceassistant.getRetailer() + "'>");
        pw.print("<input type='hidden' name='condition' value='" + voiceassistant.getCondition() + "'>");
        pw.print("<input type='hidden' name='discount' value='" + voiceassistant.getDiscount() + "'>");
        pw.print("<input type='hidden' name='productCatalog' value='voiceassistant'>");
        pw.print("<input type='hidden' name='image' value='" + voiceassistant.getImage() + "'>");
        pw.print("</tr>");
        pw.print("<tr>");
        pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
        pw.print("<td>");
        pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        pw.print("</tr>");
        pw.print("</form>");
        }

        //Accessory
      /**   for (Map.Entry<String, Accessory> entry : SaxParserDataStore.accessorys.entrySet()) {
        Accessory accessory = entry.getValue();
        pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<tr>");
        // pw.print("<td><input type='radio' name='productId' value='" + accessory.getId() + "'></td>");

        pw.print("<td>" + accessory.getName() + "</td>" +
        "<td>" + accessory.getPrice() + "</td>" +
        //  "<td>" + accessory.getRetailer() + "</td>" +
        "<td>" + accessory.getCondition() + "</td>" +
        "<td>" + accessory.getDiscount() + "</td>" +
        "<td>Accessory</td>");
        pw.print("<input type='hidden' name='productId' value='" + accessory.getId() + "'>");
        pw.print("<input type='hidden' name='productName' value='" + accessory.getName() + "'>");
        pw.print("<input type='hidden' name='price' value='" + accessory.getPrice() + "'>");
        //pw.print("<input type='hidden' name='manufacturer' value='" + accessory.getRetailer() + "'>");
        pw.print("<input type='hidden' name='condition' value='" + accessory.getCondition() + "'>");
        pw.print("<input type='hidden' name='discount' value='" + accessory.getDiscount() + "'>");
        pw.print("<input type='hidden' name='productCatalog' value='accessory'>");
        pw.print("<input type='hidden' name='image' value='" + accessory.getImage() + "'>");
        pw.print("</tr>");
        pw.print("<tr>");
        pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
        pw.print("<td>");
        pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        pw.print("</tr>");
        pw.print("</form>");
        }*/


        // for (Map.Entry<String, Accessory> entry : SaxParserDataStore.accessories.entrySet()) {
        //     Accessory accessory = entry.getValue();
        //     pw.print("<form method='post' action='RemoveUpdateProduct'>");
        //     if (accessory.getName() == null || accessory.getName().isEmpty()) {
        //         continue;
        //     }
        //     pw.print("<tr>");
        //     // pw.print("<td><input type='radio' name='productId' value='" + accessory.getId() + "'></td>");
        //
        //     pw.print("<td>" + accessory.getName() + "</td>" +
        //             "<td>" + accessory.getPrice() + "</td>" +
        //             "<td>" + accessory.getRetailer() + "</td>" +
        //             "<td>" + accessory.getCondition() + "</td>" +
        //             "<td>" + accessory.getDiscount() + "</td>" +
        //             "<td>Accessory</td>");
        //     pw.print("<input type='hidden' name='productId' value='" + accessory.getId() + "'>");
        //     pw.print("<input type='hidden' name='productName' value='" + accessory.getName() + "'>");
        //     pw.print("<input type='hidden' name='price' value='" + accessory.getPrice() + "'>");
        //     pw.print("<input type='hidden' name='manufacturer' value='" + accessory.getRetailer() + "'>");
        //     pw.print("<input type='hidden' name='condition' value='" + accessory.getCondition() + "'>");
        //     pw.print("<input type='hidden' name='discount' value='" + accessory.getDiscount() + "'>");
        //     pw.print("<input type='hidden' name='catalog' value='Accessory'>");
        //     pw.print("<input type='hidden' name='image' value='" + accessory.getImage() + "'>");
        //     pw.print("</tr>");
        //     pw.print("<tr>");
        //     //pw.print("<td></td>");
        //     pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div>");
        //     pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
        //     pw.print("</tr>");
        //     pw.print("</form>");
        // }

        pw.print("</table>");
        pw.print("</div></div></div>");
        utility.printHtml("Footer.html");

        }
            
}
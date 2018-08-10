package com.jettjia.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jettjia.springmvc.pojo.Item;
import com.jettjia.springmvc.pojo.QueryVo;
import com.jettjia.springmvc.service.ItemService;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 商品列表
     * 
     * @return
     */
    @RequestMapping("itemList")
    public ModelAndView itemList() {
        ModelAndView mav = new ModelAndView();
        // 获取商品列表
        List<Item> itemList = itemService.getItemList();
        mav.addObject("itemList", itemList);
        mav.setViewName("itemList");
        System.out.println("ItemController.itemList is run");
        return mav;
    }

    /**
     * 根据id查询商品，使用ModelAndView
     * 
     * @param request
     * @return
     */
    /*
     * @RequestMapping("itemEdit") public ModelAndView
     * itemEdit(HttpServletRequest request) { // 从request中获取请求参数 String idString
     * = request.getParameter("id"); Integer id = Integer.valueOf(idString); //
     * 根据id获取商品数据 Item item = itemService.getItemById(id); // 把结果返回给页面
     * ModelAndView mav = new ModelAndView(); mav.addObject("item", item);
     * mav.setViewName("itemEdit"); return mav; }
     */

    /**
     * 根据id查询商品，使用Model
     * 
     * @param request
     * @param model
     * @return
     */
    /*
     * @RequestMapping("itemEdit") public String itemEdit(HttpServletRequest
     * request, Model model) { // 从request中获取请求参数 String idString =
     * request.getParameter("id"); Integer id = Integer.valueOf(idString); //
     * 根据id获取商品数据 Item item = itemService.getItemById(id);
     * model.addAttribute("item", item); return "itemEdit"; }
     */

    /**
     * 根据id查询商品，使用ModelMap
     * 
     * @param request
     * @param model
     * @return
     */
    /*
     * @RequestMapping("itemEdit") public String itemEdit(HttpServletRequest
     * request, ModelMap model) { // 从request中获取请求参数 String idString =
     * request.getParameter("id"); Integer id = Integer.valueOf(idString); //
     * 根据id获取商品数据 Item item = itemService.getItemById(id);
     * model.addAttribute("item", item); return "itemEdit"; }
     */

    /**
     * 根据id查询商品，绑定简单数据类型
     * 
     * @param id
     * @param model
     * @return
     */
    /*
     * @RequestMapping("itemEdit") public String itemEdit(int id, ModelMap
     * model) { // 根据id获取商品数据 Item item = itemService.getItemById(id);
     * model.addAttribute("item", item); return "itemEdit"; }
     */

    /**
     * 根据id查询商品，绑定简单数据类型-RequestParam使用
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("itemEdit")
    public String itemEdit(@RequestParam(value = "itemId", required = true, defaultValue = "1") Integer id,
            ModelMap model) {
        // 根据id获取商品数据
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "itemEdit";
    }

    /**
     * 修改商品
     * 
     * @param item
     * @return
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping("updateItem")
    public String updateItem(Item item, Model model, MultipartFile pictureFile) throws Exception {
        // 图片上传
        // 设置图片名称，不能重复，使用uuid
        String picName = UUID.randomUUID().toString();
        // 获取文件名
        String oriName = pictureFile.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        // 开始上传
        pictureFile.transferTo(new File(("D:\\develop\\upload\\temp\\") + picName + extName));
        
        // 更新商品
        // 设置商品图片名到商品中
        item.setPic(picName + extName);
        itemService.updateItemById(item);
        model.addAttribute("item", item);
        model.addAttribute("msg", "修改商品信息成功！");
        return "itemEdit";
    }

    /**
     * 商品列表搜索
     * 
     * @param vo
     * @param model
     * @return
     */
    @RequestMapping("queryItem")
    public String queryItem(QueryVo vo, Integer[] ids, Model model) {
        if (vo.getItem() != null) {
            System.out.println(vo.getItem());
        }
        
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                System.out.println(id);
            }
        }
        
        if (vo.getItems() != null && vo.getItems().size() > 0) {
            for (Item item : vo.getItems()) {
                System.out.println(item);
            }
        }
        // 模拟搜索商品
        List<Item> itemList = itemService.getItemList();

        model.addAttribute("itemList", itemList);
        return "itemList";
    }
    
    /**
     * 测试json的交互
     * @param item
     * @return
     */
    @RequestMapping("testJson")
    public @ResponseBody Item testJson(@RequestBody Item item) {
        return item;
    }
    
    /**
     * Restful风格开发接口，实现根据id查询商品
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("item/{id}")
    @ResponseBody
    public Item itemQuery(@PathVariable("id") Integer id) {
        Item item = itemService.getItemById(id);
        return item;
    }
}

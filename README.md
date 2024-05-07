# 購物網站範例

## 功能

- 提供會員註冊及登入系統
- 用戶可以查看自身會員資料及編輯
- 用戶可以瀏覽商品並將它們添加到購物車
- 透過ecpay幫助用戶完成付款動作
- 用戶可以查看以前的訂單歷史

## 技術

- 使用Eclipse開發
- 以Java做為後端語言
- 使用JSP和Servlet來構建用戶界面和處理用戶需求
- 使用MySQL作為存儲商品、會員、購物車、訂單等信息
- 使用CSS設計頁面

## 環境設定

此專案需要的jar檔：
- log4j(2.17.1版本以上)
- Servlet
- MySQL Connector/J

## 使用說明

1.會員註冊及登入： 首先，用戶可以在頁面右上角找到註冊連結進入註冊頁面。在註冊頁面上填寫必要的資訊，然後點擊註冊按鈕完成註冊。註冊後，用戶可以使用已註冊的帳戶登入。  
2.查看會員資料： 登入後，用戶可以在用戶資料頁面查看自己的會員資料，用戶也可以在這裡進行編輯資料。  
3.瀏覽商品及購物車： 在商品頁面上，用戶可以瀏覽所有的商品。用戶可以點擊商品進入詳細頁面，並將商品添加到購物車中。用戶可以在購物車頁面查看已添加的商品，並進行結帳操作。  
4.完成付款動作： 當用戶在購物車頁面確認購買商品後，可以點擊結帳按鈕進行付款。系統將會引導用戶使用 ecpay 來完成付款動作，你可以使用以下提供的資料做為測試用途。  
     * 信用卡卡號：4311-9522-2222-2222
     * 安全碼：222
5.查看訂單歷史： 用戶可以在個人資料頁面查看以前的訂單歷史，包括訂單編號、訂單日期、總金額等信息。  

這些是使用購物網站的基本步驟和操作，用戶可以根據這些指南來進行網站的使用和操作。

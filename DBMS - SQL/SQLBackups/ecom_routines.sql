-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: ecom
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `view_product_order_count`
--

DROP TABLE IF EXISTS `view_product_order_count`;
/*!50001 DROP VIEW IF EXISTS `view_product_order_count`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_product_order_count` AS SELECT 
 1 AS `product_id`,
 1 AS `product_name`,
 1 AS `category`,
 1 AS `times_ordered`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_customer_order`
--

DROP TABLE IF EXISTS `view_customer_order`;
/*!50001 DROP VIEW IF EXISTS `view_customer_order`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_customer_order` AS SELECT 
 1 AS `customer_id`,
 1 AS `CustomerName`,
 1 AS `order_id`,
 1 AS `order_date`,
 1 AS `total_amount`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_customer_total_spent`
--

DROP TABLE IF EXISTS `view_customer_total_spent`;
/*!50001 DROP VIEW IF EXISTS `view_customer_total_spent`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_customer_total_spent` AS SELECT 
 1 AS `customer_id`,
 1 AS `CustomerName`,
 1 AS `totalSpent`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_order_details`
--

DROP TABLE IF EXISTS `view_order_details`;
/*!50001 DROP VIEW IF EXISTS `view_order_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_order_details` AS SELECT 
 1 AS `order_id`,
 1 AS `order_date`,
 1 AS `custName`,
 1 AS `ProdName`,
 1 AS `qty`,
 1 AS `unit_price`,
 1 AS `total_calculated_amount`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_customer_info`
--

DROP TABLE IF EXISTS `view_customer_info`;
/*!50001 DROP VIEW IF EXISTS `view_customer_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_customer_info` AS SELECT 
 1 AS `customer_id`,
 1 AS `name`,
 1 AS `email`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_product_order_count`
--

/*!50001 DROP VIEW IF EXISTS `view_product_order_count`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_product_order_count` AS select `p`.`product_id` AS `product_id`,`p`.`name` AS `product_name`,`p`.`category` AS `category`,count(`oi`.`order_item_id`) AS `times_ordered` from (`products` `p` left join `order_items` `oi` on((`p`.`product_id` = `oi`.`product_id`))) group by `p`.`product_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_customer_order`
--

/*!50001 DROP VIEW IF EXISTS `view_customer_order`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_customer_order` AS select `c`.`customer_id` AS `customer_id`,`c`.`name` AS `CustomerName`,`o`.`order_id` AS `order_id`,`o`.`order_date` AS `order_date`,`o`.`total_amount` AS `total_amount` from (`customer` `c` left join `orders` `o` on((`c`.`customer_id` = `o`.`customer_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_customer_total_spent`
--

/*!50001 DROP VIEW IF EXISTS `view_customer_total_spent`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_customer_total_spent` AS select `c`.`customer_id` AS `customer_id`,`c`.`name` AS `CustomerName`,sum(`o`.`total_amount`) AS `totalSpent` from (`customer` `c` left join `orders` `o` on((`c`.`customer_id` = `o`.`customer_id`))) group by `c`.`customer_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_order_details`
--

/*!50001 DROP VIEW IF EXISTS `view_order_details`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_order_details` AS select `o`.`order_id` AS `order_id`,`o`.`order_date` AS `order_date`,`c`.`name` AS `custName`,`p`.`name` AS `ProdName`,`oi`.`qty` AS `qty`,`oi`.`unit_price` AS `unit_price`,sum((`oi`.`qty` * `oi`.`unit_price`)) AS `total_calculated_amount` from (((`customer` `c` join `orders` `o` on((`c`.`customer_id` = `o`.`customer_id`))) join `order_items` `oi` on((`oi`.`order_id` = `o`.`order_id`))) join `products` `p` on((`p`.`product_id` = `oi`.`product_id`))) group by `o`.`order_id`,`o`.`order_date`,`c`.`name`,`p`.`name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_customer_info`
--

/*!50001 DROP VIEW IF EXISTS `view_customer_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_customer_info` AS select `customer`.`customer_id` AS `customer_id`,`customer`.`name` AS `name`,`customer`.`email` AS `email` from `customer` where (`customer`.`customer_id` > 3) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-03 14:43:31

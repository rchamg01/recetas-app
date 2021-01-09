// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/Usuario_App/conf/routes
// @DATE:Wed Jan 06 01:18:33 CET 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseRecetasController RecetasController = new controllers.ReverseRecetasController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseRecetasController RecetasController = new controllers.javascript.ReverseRecetasController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}

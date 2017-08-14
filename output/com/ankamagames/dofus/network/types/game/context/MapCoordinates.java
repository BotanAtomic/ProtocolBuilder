package com.ankamagames.dofus.network.types.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapCoordinates extends Object implements INetworkType {

  public int worldX = 0;
  public int worldY = 0;
  public static final int protocolId = 174;

  public void serialize(ICustomDataOutput param1) {
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
    }
    param1.writeShort(this.worldX);
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
    }
    param1.writeShort(this.worldY);
  }

  public void deserialize(ICustomDataInput param1) {
    this.worldX = param1.readShort();
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.worldX
              + ") on element of PrismGeolocalizedInformation.worldX.");
    }

    this.worldY = param1.readShort();
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.worldY
              + ") on element of PrismGeolocalizedInformation.worldY.");
    }
  }
}

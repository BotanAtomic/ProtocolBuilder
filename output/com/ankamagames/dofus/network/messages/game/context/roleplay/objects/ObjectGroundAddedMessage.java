package com.ankamagames.dofus.network.messages.game.context.roleplay.objects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectGroundAddedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int cellId = 0;
  public int objectGID = 0;
  public static final int protocolId = 3017;

  public void serialize(ICustomDataOutput param1) {
    if (this.cellId < 0 || this.cellId > 559) {
      throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeVarShort(this.cellId);
    if (this.objectGID < 0) {
      throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
    }
    param1.writeVarShort(this.objectGID);
  }

  public void deserialize(ICustomDataInput param1) {
    this.cellId = param1.readVarUhShort();
    if (this.cellId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.cellId
              + ") on element of HavenBagFurnitureInformation.cellId.");
    }

    this.objectGID = param1.readVarUhShort();
    if (this.objectGID < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.objectGID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectGID.");
    }
  }
}

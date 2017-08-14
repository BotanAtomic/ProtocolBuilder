package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSellInNpcShop;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartOkNpcShopMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number npcSellerId = 0;
  public int tokenId = 0;
  public Vector<ObjectItemToSellInNpcShop> objectsInfos;
  private FuncTree _objectsInfostree;
  public static final int protocolId = 5761;

  public void serialize(ICustomDataOutput param1) {
    if (this.npcSellerId < -9.007199254740992E15 || this.npcSellerId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.npcSellerId + ") on element npcSellerId.");
    }
    param1.writeDouble(this.npcSellerId);
    if (this.tokenId < 0) {
      throw new Exception("Forbidden value (" + this.tokenId + ") on element tokenId.");
    }
    param1.writeVarShort(this.tokenId);
    param1.writeShort(this.objectsInfos.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objectsInfos.length) {
      ((ObjectItemToSellInNpcShop) this.objectsInfos[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    ObjectItemToSellInNpcShop _loc4_ = null;
    this.npcSellerId = param1.readDouble();
    if (this.npcSellerId < -9.007199254740992E15 || this.npcSellerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.npcSellerId
              + ") on element of ExchangeStartOkNpcShopMessage.npcSellerId.");
    }

    this.tokenId = param1.readVarUhShort();
    if (this.tokenId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.tokenId
              + ") on element of ExchangeStartOkNpcShopMessage.tokenId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new ObjectItemToSellInNpcShop();
      _loc4_.deserialize(param1);
      this.objectsInfos.push(_loc4_);
      _loc3_++;
    }
  }
}

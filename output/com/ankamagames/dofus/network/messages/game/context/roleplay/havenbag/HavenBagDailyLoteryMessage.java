package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HavenBagDailyLoteryMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int returnType = 0;
  public String tokenId = "";
  public static final int protocolId = 6644;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.returnType);
    param1.writeUTF(this.tokenId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.returnType = param1.readByte();
    if (this.returnType < 0) {
      throw new Error(
          "Forbidden value (" + this.returnType + ") on element of HaapiApiKeyMessage.returnType.");
    }

    this.tokenId = param1.readVarUhShort();
    if (this.tokenId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.tokenId
              + ") on element of ExchangeStartOkNpcShopMessage.tokenId.");
    }
  }
}

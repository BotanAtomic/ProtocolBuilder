package com.ankamagames.dofus.network.messages.game.context.roleplay.delay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayDelayedObjectUseMessage extends GameRolePlayDelayedActionMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int objectGID = 0;
  public static final int protocolId = 6425;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.delayedCharacterId < -9.007199254740992E15
        || this.delayedCharacterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.delayedCharacterId + ") on element delayedCharacterId.");
    }
    param1.writeDouble(this.delayedCharacterId);
    param1.writeByte(this.delayTypeId);
    if (this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.delayEndTime + ") on element delayEndTime.");
    }
    param1.writeDouble(this.delayEndTime);

    if (this.objectGID < 0) {
      throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
    }
    param1.writeVarShort(this.objectGID);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.objectGID = param1.readVarUhShort();
    if (this.objectGID < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.objectGID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectGID.");
    }
  }
}

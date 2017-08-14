package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectUseOnCharacterMessage extends ObjectUseMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number characterId = 0;
  public static final int protocolId = 3003;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.objectUID < 0) {
      throw new Error("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }
    param1.writeVarInt(this.objectUID);

    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.characterId + ") on element characterId.");
    }
    param1.writeVarLong(this.characterId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.characterId = param1.readVarUhLong();
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.characterId
              + ") on element of StartupActionsObjetAttributionMessage.characterId.");
    }
  }
}

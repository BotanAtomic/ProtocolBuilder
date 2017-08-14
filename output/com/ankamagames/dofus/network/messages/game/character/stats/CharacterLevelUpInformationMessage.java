package com.ankamagames.dofus.network.messages.game.character.stats;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterLevelUpInformationMessage extends CharacterLevelUpMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public String name = "";
  public Number id = 0;
  public static final int protocolId = 6076;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.newLevel < 2 || this.newLevel > 206) {
      throw new Error("Forbidden value (" + this.newLevel + ") on element newLevel.");
    }
    param1.writeByte(this.newLevel);

    param1.writeUTF(this.name);
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);
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

    this.name = param1.readUTF();

    this.id = param1.readUTF();
  }
}

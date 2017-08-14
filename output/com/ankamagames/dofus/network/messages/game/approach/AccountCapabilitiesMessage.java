package com.ankamagames.dofus.network.messages.game.approach;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class AccountCapabilitiesMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int accountId = 0;
  public boolean tutorialAvailable = false;
  public int breedsVisible = 0;
  public int breedsAvailable = 0;
  public int status = -1;
  public boolean canCreateNewCharacter = false;
  public static final int protocolId = 6216;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.tutorialAvailable);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.canCreateNewCharacter);
    param1.writeByte(_loc2_);
    if (this.accountId < 0) {
      throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    if (this.breedsVisible < 0) {
      throw new Exception("Forbidden value (" + this.breedsVisible + ") on element breedsVisible.");
    }
    param1.writeVarInt(this.breedsVisible);
    if (this.breedsAvailable < 0) {
      throw new Exception(
          "Forbidden value (" + this.breedsAvailable + ") on element breedsAvailable.");
    }
    param1.writeVarInt(this.breedsAvailable);
    param1.writeByte(this.status);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Exception(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }

    this.breedsVisible = param1.readVarUhInt();
    if (this.breedsVisible < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.breedsVisible
              + ") on element of AccountCapabilitiesMessage.breedsVisible.");
    }

    this.breedsAvailable = param1.readVarUhInt();
    if (this.breedsAvailable < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.breedsAvailable
              + ") on element of AccountCapabilitiesMessage.breedsAvailable.");
    }

    this.status = param1.readByte();
    if (this.status < 0) {
      throw new Exception(
          "Forbidden value (" + this.status + ") on element of GameServerInformations.status.");
    }
  }
}

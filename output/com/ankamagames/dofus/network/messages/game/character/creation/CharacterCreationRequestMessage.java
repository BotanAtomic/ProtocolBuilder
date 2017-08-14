package com.ankamagames.dofus.network.messages.game.character.creation;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;

public class CharacterCreationRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String name = "";
  public int breed = 0;
  public boolean sex = false;
  public Vector<Integer> colors;
  public int cosmeticId = 0;
  private FuncTree _colorstree;
  private int _colorsindex = 0;
  public static final int protocolId = 160;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.name);
    param1.writeByte(this.breed);
    param1.writeBoolean(this.sex);
    int _loc2_ = 0;
    while (_loc2_ < 5) {
      param1.writeInt(this.colors[_loc2_]);
      _loc2_++;
    }
    if (this.cosmeticId < 0) {
      throw new Error("Forbidden value (" + this.cosmeticId + ") on element cosmeticId.");
    }
    param1.writeVarShort(this.cosmeticId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.name = param1.readUTF();

    this.breed = param1.readByte();

    this.sex = param1.readBoolean();

    int _loc2_ = 0;
    while (_loc2_ < 5) {
      this.colors[_loc2_] = param1.readInt();
      _loc2_++;
    }
    this.cosmeticId = param1.readVarUhShort();
    if (this.cosmeticId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.cosmeticId
              + ") on element of RemodelingInformation.cosmeticId.");
    }
  }
}

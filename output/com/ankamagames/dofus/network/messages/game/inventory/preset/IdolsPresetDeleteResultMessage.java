package com.ankamagames.dofus.network.messages.game.inventory.preset;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdolsPresetDeleteResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int presetId = 0;
  public int code = 2;
  public static final int protocolId = 6605;

  public void serialize(ICustomDataOutput param1) {
    if (this.presetId < 0) {
      throw new Error("Forbidden value (" + this.presetId + ") on element presetId.");
    }
    param1.writeByte(this.presetId);
    param1.writeByte(this.code);
  }

  public void deserialize(ICustomDataInput param1) {
    this.presetId = param1.readByte();
    if (this.presetId < 0) {
      throw new Error(
          "Forbidden value (" + this.presetId + ") on element of ShortcutObjectPreset.presetId.");
    }

    this.code = param1.readByte();
    if (this.code < 0) {
      throw new Error(
          "Forbidden value ("
              + this.code
              + ") on element of InventoryPresetUseResultMessage.code.");
    }
  }
}

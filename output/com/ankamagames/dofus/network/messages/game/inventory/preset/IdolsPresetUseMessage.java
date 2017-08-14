package com.ankamagames.dofus.network.messages.game.inventory.preset;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdolsPresetUseMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int presetId = 0;
  public boolean party = false;
  public static final int protocolId = 6615;

  public void serialize(ICustomDataOutput param1) {
    if (this.presetId < 0) {
      throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
    }
    param1.writeByte(this.presetId);
    param1.writeBoolean(this.party);
  }

  public void deserialize(ICustomDataInput param1) {
    this.presetId = param1.readByte();
    if (this.presetId < 0) {
      throw new Exception(
          "Forbidden value (" + this.presetId + ") on element of ShortcutObjectPreset.presetId.");
    }

    this.party = param1.readBoolean();
  }
}

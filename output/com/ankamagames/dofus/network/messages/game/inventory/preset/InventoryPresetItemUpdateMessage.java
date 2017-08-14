package com.ankamagames.dofus.network.messages.game.inventory.preset;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.PresetItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetItemUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int presetId = 0;
  public PresetItem presetItem;
  private FuncTree _presetItemtree;
  public static final int protocolId = 6168;

  public void serialize(ICustomDataOutput param1) {
    if (this.presetId < 0) {
      throw new Error("Forbidden value (" + this.presetId + ") on element presetId.");
    }
    param1.writeByte(this.presetId);
    this.presetItem.serializeAs_PresetItem(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.presetId = param1.readByte();
    if (this.presetId < 0) {
      throw new Error(
          "Forbidden value (" + this.presetId + ") on element of ShortcutObjectPreset.presetId.");
    }

    this.presetItem = new PresetItem();
    this.presetItem.deserialize(param1);
  }
}

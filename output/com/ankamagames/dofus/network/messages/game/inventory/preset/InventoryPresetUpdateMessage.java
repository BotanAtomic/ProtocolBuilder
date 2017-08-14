package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.Preset;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Preset preset;
  private FuncTree _presettree;
  public static final int protocolId = 6171;

  public void serialize(ICustomDataOutput param1) {
    this.preset.serializeAs_Preset(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.preset = new Preset();
    this.preset.deserialize(param1);
  }
}

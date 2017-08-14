package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.prism.PrismFightersInformation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismFightAddedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public PrismFightersInformation fight;
  private FuncTree _fighttree;
  public static final int protocolId = 6452;

  public void serialize(ICustomDataOutput param1) {
    this.fight.serializeAs_PrismFightersInformation(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fight = new PrismFightersInformation();
    this.fight.deserialize(param1);
  }
}

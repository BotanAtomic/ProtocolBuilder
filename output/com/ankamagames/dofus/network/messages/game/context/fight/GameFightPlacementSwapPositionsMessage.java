package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.IdentifiedEntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightPlacementSwapPositionsMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<IdentifiedEntityDispositionInformations> dispositions;
  private FuncTree _dispositionstree;
  private int _dispositionsindex = 0;
  public static final int protocolId = 6544;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    while (_loc2_ < 2) {
      this.dispositions[_loc2_].serializeAs_IdentifiedEntityDispositionInformations(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = 0;
    while (_loc2_ < 2) {
      this.dispositions[_loc2_] = new IdentifiedEntityDispositionInformations();
      this.dispositions[_loc2_].deserialize(param1);
      _loc2_++;
    }
  }
}

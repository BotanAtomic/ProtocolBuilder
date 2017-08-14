package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.AccountHouseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AccountHouseMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<AccountHouseInformations> houses;
  private FuncTree _housestree;
  public static final int protocolId = 6315;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.houses.length);
    int _loc2_ = 0;
    while (_loc2_ < this.houses.length) {
      ((AccountHouseInformations) this.houses[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    AccountHouseInformations _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new AccountHouseInformations();
      _loc4_.deserialize(param1);
      this.houses.push(_loc4_);
      _loc3_++;
    }
  }
}

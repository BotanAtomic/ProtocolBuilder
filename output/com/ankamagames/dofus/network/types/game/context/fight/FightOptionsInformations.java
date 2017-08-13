package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightOptionsInformations extends Object implements INetworkType {

    private int protocolId = 20;
    private boolean isSecret = false;
    private boolean isRestrictedToPartyOnly = false;
    private boolean isClosed = false;
    private boolean isAskingForHelp = false;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.isSecret);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isRestrictedToPartyOnly);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.isClosed);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.isAskingForHelp);
         param1.writeByte(_loc2_);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.isSecret = BooleanByteWrapper.getFlag(_loc2_,0);
         this.isRestrictedToPartyOnly = BooleanByteWrapper.getFlag(_loc2_,1);
         this.isClosed = BooleanByteWrapper.getFlag(_loc2_,2);
         this.isAskingForHelp = BooleanByteWrapper.getFlag(_loc2_,3);
    }

}
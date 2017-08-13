package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.achievement.Achievement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementDetailedListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6358;
    private boolean _isInitialized = false;
    private Achievement[] startedAchievements;
    private Achievement[] finishedAchievements;
    private FuncTree _startedAchievementstree;
    private FuncTree _finishedAchievementstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.startedAchievements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.startedAchievements.length)
         {
            (this.startedAchievements[_loc2_] as Achievement).serializeAs_Achievement(param1);
            _loc2_++;
         }
         param1.writeShort(this.finishedAchievements.length);
         int _loc3_ = 0;
         while(_loc3_ < this.finishedAchievements.length)
         {
            (this.finishedAchievements[_loc3_] as Achievement).serializeAs_Achievement(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Achievement _loc6_ = null;
         Achievement _loc7_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new Achievement();
            _loc6_.deserialize(param1);
            this.startedAchievements.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new Achievement();
            _loc7_.deserialize(param1);
            this.finishedAchievements.push(_loc7_);
            _loc5_++;
         }
    }

}
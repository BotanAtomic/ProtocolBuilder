package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.MonsterBoosts;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRefreshMonsterBoostsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6618;
    private boolean _isInitialized = false;
    private MonsterBoosts[] monsterBoosts;
    private MonsterBoosts[] familyBoosts;
    private FuncTree _monsterBooststree;
    private FuncTree _familyBooststree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.monsterBoosts.length);
         int _loc2_ = 0;
         while(_loc2_ < this.monsterBoosts.length)
         {
            (this.monsterBoosts[_loc2_] as MonsterBoosts).serializeAs_MonsterBoosts(param1);
            _loc2_++;
         }
         param1.writeShort(this.familyBoosts.length);
         int _loc3_ = 0;
         while(_loc3_ < this.familyBoosts.length)
         {
            (this.familyBoosts[_loc3_] as MonsterBoosts).serializeAs_MonsterBoosts(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         MonsterBoosts _loc6_ = null;
         MonsterBoosts _loc7_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new MonsterBoosts();
            _loc6_.deserialize(param1);
            this.monsterBoosts.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new MonsterBoosts();
            _loc7_.deserialize(param1);
            this.familyBoosts.push(_loc7_);
            _loc5_++;
         }
    }

}
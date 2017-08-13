package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.fight.ProtectedEntityWaitingForHelpInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorWaitingForHelpInformations extends TaxCollectorComplementaryInformations implements INetworkType {

    private int protocolId = 447;
    private ProtectedEntityWaitingForHelpInfo waitingForHelpInfo;
    private FuncTree _waitingForHelpInfotree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_TaxCollectorComplementaryInformations(param1);
         this.waitingForHelpInfo.serializeAs_ProtectedEntityWaitingForHelpInfo(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
         this.waitingForHelpInfo.deserialize(param1);
    }

}